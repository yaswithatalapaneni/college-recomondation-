document.addEventListener('DOMContentLoaded', function () {
    var form = document.getElementById('collegeSearchForm');
    var resultsSection = document.createElement('section');
    resultsSection.id = 'searchResults';
    document.querySelector('main').appendChild(resultsSection);

    form.addEventListener('submit', function (event) {
        event.preventDefault();

        var ranking = document.getElementById('ranking').value;
        var location = document.getElementById('collegeLocation').value;
        var course = document.getElementById('collegeCourse').value;

        var params = new URLSearchParams();
        if (location) params.append('location', location);
        if (course) params.append('course', course);
        if (ranking) {
            var rankingMap = {
                'Top 10': '10',
                'Top 50': '50',
                'Top 100': '100',
                'Above 100': '101'
            };
            params.append('ranking', rankingMap[ranking] || ranking);
        }

        fetch('/find-colleges?' + params.toString())
            .then(function (response) {
                if (!response.ok) throw new Error('Network response was not ok');
                return response.json();
            })
            .then(function (colleges) {
                displayColleges(colleges);
            })
            .catch(function (error) {
                console.error('Fetch error:', error);
                resultsSection.innerHTML = '<p class="error">Error fetching college data. Please try again.</p>';
            });
    });

    function displayColleges(colleges) {
        if (colleges.length === 0) {
            resultsSection.innerHTML = '<p class="no-results">No colleges found with the selected filters.</p>';
            return;
        }

        var html = '<div class="college-grid">';
        colleges.forEach(function (college) {
            html += `
                <div class="college-card">
                    <h3>${college.name}</h3>
                    <p><strong>Location:</strong> ${college.location}</p>
                    <p><strong>Course:</strong> ${college.course}</p>
                    <p><strong>Ranking:</strong> ${college.ranking}</p>
                </div>
            `;
        });
        html += '</div>';

        resultsSection.innerHTML = html;
    }
});

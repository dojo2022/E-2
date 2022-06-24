
  function text(){
  var ctx = document.getElementById('canvas').getContext('2d');
            var myChart = new Chart(ctx, {
                // The type of chart we want to create
                type: 'line',

                // The data for our dataset
                data: {
                    labels: ['1', '2', '3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14','15',
                    '16', '17', '18', '19', '20', '21','22', '23', '24', '25', '26', '27', '28', '29', '30' ,'31'],
                    datasets: [{
                        label: '',
                        backgroundColor: 'rgb(255, 99, 132)',
                        borderColor: 'rgb(255, 99, 132)',
                        fill: false,
                        data: [60, 58, 58, , 60, 60, 59, 58, 57]
                    }]
                },

                // Configuration options go here
                options: {
                  scales: {
            yAxes: [{
                ticks: {
                  suggestedMin: 40,
           suggestedMax: 70,
           stepSize: 5
                }
            }]
        },
        annotation: {
        drawTime: 'afterDatasetsDraw',
        annotations: [
            {
                id: 'hline',
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-0',
                value: 59,
                borderColor: 'black',
                borderWidth: 2,
                label: {
                    backgroundColor: "red",
                    content: "平均値",
                    enabled: true
                },
            },
        ]
    }
    }
            });

}
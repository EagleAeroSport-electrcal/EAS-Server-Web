var documentReady = false;
var $content = $("#content");
var $charts = $("#charts");
var $submitButton = $("#btn1");
var $sensorSelect = $("#sensor_Select");
var charts = [];

var LineChart;
// noinspection BadExpressionStatementJS
LineChart = {
    ctx:"",
    chart:"",

    getLength: function () {
        return this.chart.datasets.length;
    },

    addData: function (label, data) {
        this.chart.data.labels.push(label);
        for(var i = 0; i < this.chart.data.datasets.length; i++){
            this.chart.data.datasets[i].data.push(data);
        }

        this.chart.update();
    },

    removeData: function () {
        this.chart.data.labels.shift();
        for(var i = 0; i < this.chart.data.datasets.length; i++){
            this.chart.data.datasets[i].data.shift();
        }
        this.chart.update();
    },

    updateChart: function (label, data) {
        this.removeData();
        this.addData(label, data);
    },

    buttonFunction: function () {
        console.info("in buttonFunction");

        this.chart = new Chart(this.ctx, {
            type: 'line',
            data: {
                datasets: [{
                    label: 'Sensor Data',
                    data: [],
                    backgroundColor: [
                        'rgba(0, 0, 255, 0.2)'
                    ],
                    borderColor: [
                        'rgba(0,0,255,1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
        });
    }
};

var data = 1;
function addData(ac) {
    data = data + Math.round(5 + Math.random() * (-5 - 5));

    if (ac.chart.data.datasets[0].data.length > 30) {
        ac.updateChart(Date.now(), data);
    }
    else{
        ac.addData(Date.now(), data);
    }
}

$(document).ready(function() {
    console.info("Page Loaded");
    $charts.hide()

    var chart1 = Object.create(LineChart);
    chart1.ctx =  $("#chart1");

    charts.push(chart1);

    var chart2 = Object.create(LineChart);
    chart2.ctx = $("#chart2");

    charts.push(chart2)

    charts[0].buttonFunction();

    charts[1].buttonFunction();

    documentReady = true;


});

$submitButton.on('click', function (e) {
    if(documentReady) {
        $charts.show();
        $sensorSelect.hide();

        setInterval(function () {
            addData(charts[0])
        }, 1000);
        setInterval(function () {
            addData(charts[1])
        }, 1000);
    }
})
let documentReady = false;
let $content = $("#content");
let $charts = $("#charts");
let $submitButton = $("#btn1");
let $sensorSelect = $("#sensor_Select");
let charts = [];

let LineChart;
// noinspection BadExpressionStatementJS
LineChart = {
    ctx:"",
    chart:"",
    data:1,

    getLength: function () {
        return this.chart.datasets.length;
    },

    addDataPoint: function (label, data) {
        this.chart.data.labels.push(label);
        for (let dataset of this.chart.data.datasets)
            dataset.data.push(data);
        this.chart.update();
    },

    removeData: function () {
        this.chart.data.labels.shift();
        for (let dataset of this.chart.data.datasets)
            dataset.data.shift();
        this.chart.update();
    },

    updateChart: function (label, data) {
        this.removeData();
        this.addDataPoint(label, data);
    },

    addData: function() {
        this.data += Math.round((10 * Math.random() - 5) - (.01 * this.data));

        if (this.chart.data.datasets[0].data.length >= 30) {
            this.updateChart(Date.now(), this.data);
        }
        else{
            this.addDataPoint(Date.now(), this.data);
        }
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

//Server send event info web page https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events


function makeChart(id) {
    let chart = Object.create(LineChart);
    chart.ctx = $(`#${id}`);
    charts.push(chart);
    chart.buttonFunction();

    // relabel chart
    chart.chart.data.datasets[0].label = id;
}

function makeCharts(ids) {
    // gen html
    for (let id of ids)
        $charts.append(`<canvas id="${id}"/>`);

    // gen charts
    for (let id of ids)
        makeChart(id);
}

$(document).ready(function() {
    console.info("Page Loaded");
    $charts.hide();

    let ids = ["ch1", "bEST_cHART", "i_like_charts", "mostGudChart"];
    // let ids = [];
    // for (let i = 0; i < 10; i++)
    //     ids[i] = "chart" + i;
    makeCharts(ids);

    documentReady = true;
});

$submitButton.on('click', function (e) {
    if(documentReady) {
        $charts.show();
        $sensorSelect.hide();

        for (let chart of charts) {
            setInterval(function() {
                chart.addData();
            }, 1000);
        }
    }
})
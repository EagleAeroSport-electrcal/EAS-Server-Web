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

    getLength: function () {
        return this.chart.datasets.length;
    },

    addData: function (label, data) {
        this.chart.data.labels.push(label);
        // for(let i = 0; i < this.chart.data.datasets.length; i++){
        //     this.chart.data.datasets[i].data.push(data);
        // }
        for (let dataset of this.chart.data.datasets)
            dataset.data.push(data);
        this.chart.update();
    },

    removeData: function () {
        this.chart.data.labels.shift();
        // for(let i = 0; i < this.chart.data.datasets.length; i++){
        //     this.chart.data.datasets[i].data.shift();
        // }
        for (let dataset of this.chart.data.datasets)
            dataset.data.shift();
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

let data = 1;
function addData(ac) {
    data += Math.round((10 * Math.random() - 5) - (.01 * data));

    if (ac.chart.data.datasets[0].data.length > 30) {
        ac.updateChart(Date.now(), data);
    }
    else{
        ac.addData(Date.now(), data);
    }
}


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
    let chartsDIV = document.getElementById("charts");
    for (let id of ids)
        chartsDIV.innerHTML += `<canvas id="${id}"/>`;

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
                addData(chart);
            }, 1000);
        }
    }
})
var i = 1;

function getLine(){

    $.ajax({
        url: "Terminal",
        success: function (sdata, textStatus, jqXHR) {
            console.log("success");
            console.log(sdata);
            $("#terminal-body").append(sdata);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("error");
            console.log(errorThrown);
        }
    });
}

var interval = setInterval(getLine,5000);


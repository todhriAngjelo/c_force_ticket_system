var jsonStringData = '[{ "ticked_id": "0", "ticked_price": "12", "ticket_title": "Henchman" }, { "ticked_id": "1", "ticked_price": "13", "ticket_title": "Priest" }, { "ticked_id": "2", "ticked_price": "14", "ticket_title": "Captain" }]';
/*
var jsonStringData = '[
  {
    "Name":"John",
    "LName":"Doe",
    "Occupation":"Henchman"
  },
  {
    "Name":"Jane",
    "LName":"Doe",
    "Occupation":"Priest"
  },
  {
    "Name":"Steve",
    "LName":"Rogers",
    "Occupation":"Captain"
  }
]';
*/


$('#loadBtn').on('click', function () {
    var jsonData = JSON.parse(jsonStringData);

    for (var i = 0; i < jsonData.length; i++) {
        var jsonObj = jsonData[i];
        var $tr = $("<tr>");
        var $ticked_id = $("<td>");
        var $ticked_price = $("<td>");
        var $ticket_title = $("<td>");
        $ticked_id.append(jsonObj.ticked_id);
        $ticked_price.append(jsonObj.ticked_price);
        $ticket_title.append(jsonObj.ticket_title);
        $tr.append($ticked_id);
        $tr.append($ticked_price);
        $tr.append($ticket_title);
        $('#tableBody').append($tr);
    }
});

// onLoad Function
function parseJson() {
  var jsonData = JSON.parse(jsonStringData);

  for (var i = 0; i < jsonData.length; i++) {
    var jsonObj = jsonData[i];
    var $tr = $("<tr>");
    var $ticked_id = $("<td>");
    var $ticked_price = $("<td>");
    var $ticket_title = $("<td>");
    $ticked_id.append(jsonObj.ticked_id);
    $ticked_price.append(jsonObj.ticked_price);
    $ticket_title.append(jsonObj.ticket_title);
    $tr.append($ticked_id);
    $tr.append($ticked_price);
    $tr.append($ticket_title);
    $('#tableBody').append($tr);
  }
};
 
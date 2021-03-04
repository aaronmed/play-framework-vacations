window.onload = function () {
  if (localStorage.getItem('dark').localeCompare('true') == 0) {
    darkMode();
  }
};

function darkMode() {
  changeBody();
  changeCards();
  changeCardsBody();
  changeFormControl();
}

function changeBody() {
  if (document.body.style.backgroundColor == "rgb(63, 62, 62)") {
    document.body.style.backgroundColor = "white";
    document.body.style.color = "black";
    localStorage.setItem('dark', 'false');
  } else {
    document.body.style.backgroundColor = "rgb(63, 62, 62)";
    document.body.style.color = "white";
    localStorage.setItem('dark', 'true');
  }
}


function changeCards() {
  var x = document.getElementsByClassName("card");
  var i;
  for (i = 0; i < x.length; i++) {
    if (x[i].style.backgroundColor == "black") {
      x[i].style.backgroundColor = "white";
    } else {
      x[i].style.backgroundColor = "black";
    }
  }
}

function changeCardsBody() {
  var x = document.getElementsByClassName("list-group-item");
  var i;
  for (i = 0; i < x.length; i++) {
    if (x[i].style.backgroundColor == "black") {
      x[i].style.backgroundColor = "white";
    } else {
      x[i].style.backgroundColor = "black";
    }
  }
}

function changeFormControl() {
  var x = document.getElementsByClassName("form-control");
  var i;
  for (i = 0; i < x.length; i++) {
    console.log(x[i].style.color);
    if (x[i].style.color == "black") {
      x[i].style.color = "white";
    } else {
      x[i].style.color = "black";
    }
  }
}



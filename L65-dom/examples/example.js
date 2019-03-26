var ball=document.getElementById('ball');


//document.addEventListener('onload', function(){...});

document.onload = function(){
	ball=document.getElementById('ball');
} 

ball.onmousedown = function(e) { 
   // 1. отследить нажатие

  // подготовить к перемещению
  // 2. разместить на том же месте, но в абсолютных координатах
  ball.style.position = 'absolute';
  moveAt(e, ball);
  // переместим в body, чтобы мяч был точно не внутри position:relative
  //document.body.appendChild(ball);
  //document.getElementByTag('body').appendChild(ball);
  //document.getElementByTag('span').appendChild(ball);
  
  ball.style.zIndex = 1000; // показывать мяч над другими элементами

  // передвинуть мяч под координаты курсора
  // и сдвинуть на половину ширины/высоты для центрирования
  function moveAt(e, elem) {
    ball.style.left = e.pageX - elem.offsetWidth / 2 + 'px';
    ball.style.top = e.pageY - elem.offsetHeight / 2 + 'px';
  }

  // 3, перемещать по экрану
  document.onmousemove = function(e) {
    moveAt(e, ball);
  }

  // 4. отследить окончание переноса
  ball.onmouseup = function() {
    document.onmousemove = null;
    ball.onmouseup = null;
  }
}
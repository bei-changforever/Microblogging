  document.addEventListener('mousemove', function (e) {
    var x = e.pageX;
    var y = e.pageY;
    var pic = document.querySelector('.img');
    pic.style.left = x - 10 + 'px';
    pic.style.top = y - 50 + 'px';
})
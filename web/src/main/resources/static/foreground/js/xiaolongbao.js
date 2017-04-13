function b() {
	h = $(window).height();
	t = $(document).scrollTop();
	if (t > h) {
		$('#gotop').show();
	} else {
		$('#gotop').hide();
	}
}
$(document).ready(function(e) {
	b();
	$('#gotop').click(function() {
		$(document).scrollTop(0);
	})
});

$(window).scroll(function(e) {
	b();
})


/*绑定事件*/
function addEvent(obj, sType, fn) {
	if (obj.addEventListener) {
		obj.addEventListener(sType, fn, false);
	} else {
		obj.attachEvent('on' + sType, fn);
	}
};
function removeEvent(obj, sType, fn) {
	if (obj.removeEventListener) {
		obj.removeEventListener(sType, fn, false);
	} else {
		obj.detachEvent('on' + sType, fn);
	}
};
function prEvent(ev) {
	var oEvent = ev || window.event;
	if (oEvent.preventDefault) {
		oEvent.preventDefault();
	}
	return oEvent;
}

/*页面载入后*/
window.onload = function() {
	var oImg = document.getElementById('oImg');
	/*拖拽功能*/
	(function() {
		addEvent(
				oImg,
				'mousedown',
				function(ev) {
					var oEvent = prEvent(ev), oParent = oImg.parentNode, disX = oEvent.clientX
							- oImg.offsetLeft, disY = oEvent.clientY
							- oImg.offsetTop, startMove = function(ev) {
						if (oParent.setCapture) {
							oParent.setCapture();
						}
						var oEvent = ev || window.event, l = oEvent.clientX
								- disX, t = oEvent.clientY - disY;
						oImg.style.left = l + 'px';
						oImg.style.top = t + 'px';
						oParent.onselectstart = function() {
							return false;
						}
					}, endMove = function(ev) {
						if (oParent.releaseCapture) {
							oParent.releaseCapture();
						}
						oParent.onselectstart = null;
						removeEvent(oParent, 'mousemove', startMove);
						removeEvent(oParent, 'mouseup', endMove);
					};
					addEvent(oParent, 'mousemove', startMove);
					addEvent(oParent, 'mouseup', endMove);
					return false;
				});

	})();
};

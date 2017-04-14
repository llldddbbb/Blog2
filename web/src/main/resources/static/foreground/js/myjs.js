/**
 * Created by ldb on 2017/4/14.
 */
new WOW().init();

$(document).ready(function () {
    var entries = [
        {label: 'Back to top', url: '#', target: '_top'},
        {label: 'Bootstrap', url: '#', target: '_top'},
        {label: 'Carousel', url: '#', target: '_top'},
        {label: 'Countdown', url: '#', target: '_top'},
        {label: 'Dropdown Menu', url: '#', target: '_top'},
        {label: 'CodePen', url: 'http://codepen.io/', target: '_top'},
        {label: 'three.js', url: 'http://threejs.org/', target: '_top'},
        {label: 'Form Validation', url: '#', target: '_top'},
        {label: 'JS Compress', url: 'http://jscompress.com/', target: '_top'},
        {label: 'TinyPNG', url: 'https://tinypng.com/', target: '_top'},
        {label: 'Can I Use', url: 'http://caniuse.com/', target: '_top'},
        {label: 'URL shortener', url: 'https://goo.gl/', target: '_top'},
        {label: 'Grid Layout', url: '#', target: '_top'},
        {label: 'Twitter', url: 'https://twitter.com/', target: '_top'},
        {label: 'deviantART', url: 'http://nkunited.deviantart.com/', target: '_top'},
        {label: 'Gulp', url: 'http://gulpjs.com/', target: '_top'},
        {label: 'Browsersync', url: 'https://www.browsersync.io/', target: '_top'},
        {label: 'GitHub', url: 'https://github.com/', target: '_top'},
        {label: 'Shadertoy', url: 'https://www.shadertoy.com/', target: '_top'},
        {label: 'Tree View', url: '#', target: '_top'},
        {label: 'jsPerf', url: 'http://jsperf.com/', target: '_top'},
        {label: 'Foundation', url: 'http://foundation.zurb.com/', target: '_top'},
        {label: 'CreateJS', url: 'http://createjs.com/', target: '_top'},
        {label: 'Velocity.js', url: 'http://julian.com/research/velocity/', target: '_top'},
        {label: 'TweenLite', url: 'https://greensock.com/docs/#/HTML5/GSAP/TweenLite/', target: '_top'},
        {label: 'jQuery', url: 'https://jquery.com/', target: '_top'},
        {label: 'Notification', url: '#', target: '_top'},
        {label: 'Parallax', url: '#', target: '_top'}
    ];

    var settings = {

        entries: entries,
        width: '100%',
        height: '100%',
        radius: '78%',
        radiusMin: '50%',
        bgDraw: true,
        bgColor: '#FFF',
        opacityOver: 1.00,
        opacityOut: 0.13,
        opacitySpeed: 6,
        fov: 800,
        speed: 0.5,
        fontFamily: 'Oswald, Arial, sans-serif',
        fontSize: '15',
        fontColor: '#000',
        fontWeight: 'normal',//bold
        fontStyle: 'normal',//italic
        fontStretch: 'normal',//wider, narrower, ultra-condensed, extra-condensed, condensed, semi-condensed, semi-expanded, expanded, extra-expanded, ultra-expanded
        fontToUpperCase: false

    };

    //var svg3DTagCloud = new SVG3DTagCloud( document.getElementById( 'holder'  ), settings );
    $('#tag-cloud').svg3DTagCloud(settings);


    $( '#cd-dropdown' ).dropdown( {
        gutter : 5,
        delay : 100,
        random : true
    } );



    $('body').on("click",'.heart',function()
    {

        var A=$(this).attr("id");
        var B=A.split("like");
        var messageID=B[1];
        var C=parseInt($("#likeCount"+messageID).html());
        $(this).css("background-position","")
        var D=$(this).attr("rel");

        if(D === 'like')
        {
            $("#likeCount"+messageID).html(C+1);
            $(this).addClass("heartAnimation").attr("rel","unlike");
        }
        else
        {
            alert("您已经点过赞了哦，感谢您的支持");
            /*$("#likeCount"+messageID).html(C-1);
            $(this).removeClass("heartAnimation").attr("rel","like");
            $(this).css("background-position","left");*/
        }


    });

});

function siteTime(){
    window.setTimeout("siteTime()", 1000);
    var seconds = 1000;
    var minutes = seconds * 60;
    var hours = minutes * 60;
    var days = hours * 24;
    var years = days * 365;
    var today = new Date();
    var todayYear = today.getFullYear();
    var todayMonth = today.getMonth();
    var todayDate = today.getDate();
    var todayHour = today.getHours();
    var todayMinute = today.getMinutes();
    var todaySecond = today.getSeconds();

    var t1 = Date.UTC(2016,8,29,0,0,00);
    var t2 = Date.UTC(todayYear,todayMonth,todayDate,todayHour,todayMinute,todaySecond);
    var diff = t2-t1;

    var diffYears = Math.floor(diff/years);
    var diffDays = Math.floor((diff/days)-diffYears*365);
    var diffHours = Math.floor((diff-(diffYears*365+diffDays)*days)/hours);
    var diffMinutes = Math.floor((diff-(diffYears*365+diffDays)*days-diffHours*hours)/minutes);
    var diffSeconds = Math.floor((diff-(diffYears*365+diffDays)*days-diffHours*hours-diffMinutes*minutes)/seconds);
    $("#siteTime").html("本站已运行 "+diffYears+" 年 "+diffDays+" 天 "+diffHours+" 小时 "+diffMinutes+" 分钟 "+diffSeconds+" 秒");
}
siteTime();

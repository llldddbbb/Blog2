/**
 * Created by ldb on 2017/4/14.
 */
new WOW().init();

$(document).ready(function () {



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
            $.ajax({
                url:'/like',
                type:'POST',
                async:true,    //或false,是否异步
                data:{
                },
                success:function (result) {
                    var result=eval("("+result+")");
                    if(result.success){
                    }else{
                        alert("点赞失败，系统可能出了故障哦~~~~(>_<)~~~~")
                    }
                }

            });
        }
        else
        {
            alert("您已经点过赞了哦，感谢您的支持(∩_∩)");
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

    var t1 = Date.UTC(2017,4,1,13,0,00);
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

function parse() {
    $(".sourceText").emojiParse({
        icons: [{
            path: "/foreground/images/qq/",
            file: ".gif",
            placeholder: "#qq_{alias}#"
        }]
    });
}


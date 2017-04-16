; (function ($, window, document, undefined) {
    //'use strict';
    var pluginName = 'vivaTimeline';//Plugin名稱

    //Timeline建構式
    var Timeline = function (element, opt) {
        //私有變數
        this.target = element;
        this.carouselInterval;
        this.checkImgLoad;
        this.imgLoad = false;
        //初始化
        this._init(opt);
                    
        this._event();
        
    }

    //ImportKML2D預設參數
    Timeline.options = {
        carousel: true,
        carouselTime: 10000
    }

    //Timeline私有方法
    Timeline.prototype = {
        //初始化
        _init: function (_opt) {
            //合併自訂參數與預設參數
            var self = this;
            self.options = $.extend(true, {}, Timeline.options, _opt);

            self.target
                .find('.events-body')
                .each(function(){
                    var rowcount = $(this).find('.row').length;
                    if(rowcount > 1) {
                        var html = "<ol>";
                        for(var i = 0; i < rowcount; i++){
                            html += "<li data-target='" + i + "'></li>";
                        }
                        html += "</ol>";
                        $(this)
                            .siblings('.events-footer')
                            .html(html)
                            .find('li')
                            .first()
                            .addClass('active');
                    }
                });
            
            self.target
                .find('.events-body')
                .each(function(){
                    $(this)
                        .find('.row')
                        .first()
                        .show()
                        .siblings()
                        .hide();  
                });              
                             
            self.target
                .find('img').on('load', function(){
                    self.target
                        .find('.events-body')
                        .each(function(){
                            var maxHeight = 0;
                            $(this)
                                .find('.row')
                                .each(function(){                                    
                                    if($(this).height() > maxHeight){
                                        maxHeight = $(this).height();
                                    }
                                });                                                        
                            $(this).find('.row').height(maxHeight);
                        });                                
                }); 
        },

        //綁定事件
        _event: function () {
            var self = this;
            self.target
                .find('.events-header')
                .click(function(){
                    $(this)
                        .siblings('.events-body').slideToggle()
                        .end()
                        .siblings('.events-footer').toggle();
                });

            self.target
                .find('.events-footer li')
                .click(function(){
                    self._carousel($(this));
                });

            if(self.options.carousel){
                self.carouselInterval = setInterval(function(){
                    self._carousel();
                }, self.options.carouselTime);

                self.target
                    .find('.events')
                    .hover(function(){
                        clearInterval(self.carouselInterval);
                        self.carouselInterval = null;
                        
                    }, function(){
                        if(self.carouselInterval == undefined){
                            self.carouselInterval = setInterval(function(){
                                self._carousel();
                            }, self.options.carouselTime);
                        }
                    });
            }
        },
        
        //自動輪播
        _carousel: function(_container) {
            var self = this;
            if(_container == undefined){
                self.target
                    .find('.events-footer .active')
                    .each(function(){
                        var nextTarget;
                        if($(this).is(':last-child')){
                            nextTarget = $(this).siblings().first();
                        }
                        else{
                            nextTarget = $(this).next();
                        }
                        self._carousel(nextTarget);
                    });
            }
            else{
                var target = _container.data().target;

                _container
                    .addClass('active')
                    .siblings()
                    .removeClass('active');
                    
                _container
                    .closest('.events-footer')
                    .siblings('.events-body')
                    .find('.row')
                    .eq(target).show()
                    .siblings().hide();  
            }
        }
    }

    //公開方法
    $.fn[pluginName] = function (options, args) {
        var timeline;
        this.each(function () {
            timeline = new Timeline($(this), options);
        });
        return this;
    }
})(jQuery, window, document);
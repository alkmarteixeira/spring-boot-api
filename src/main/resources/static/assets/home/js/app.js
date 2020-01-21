//------------------------------------------------------------------
//[Landing Page JavaScript Structure]

//Project:	Yima Admin App
//Version:	1.0.0
//Last change:	8/5/16 [Changelog: (http://www.IssatisLab.com)]
//Implemented By:	IssatisLab (http://www.IssatisLab.com)


//[Table of contents]

// Devive Animations
// Testimonials Slider
// Tooltip
// Navigation Toggle
// Scroll To
// Smooth Scrolling
// Map
//-------------------------------------------------------------------

var yimaHomeLogin = function () {
    return {
        init: function () {
            //------------------------------------------------------------------
            //[Device Animations]
            //--
            $('.wp1').waypoint(function () {
                $('.wp1').addClass('animated fadeInUp');
            }, {
                offset: '75%'
            });
            $('.wp2').waypoint(function () {
                $('.wp2').addClass('animated fadeInUp');
            }, {
                offset: '75%'
            });
            $('.wp3').waypoint(function () {
                $('.wp3').addClass('animated fadeInRight');
            }, {
                offset: '75%'
            });

            //------------------------------------------------------------------
            //[Testimonials Slider]
            //--
            $('.flexslider').flexslider({
                animation: "slide"
            });

            //------------------------------------------------------------------
            //[Tooltip]
            //--
            $('[data-toggle="tooltip"]').tooltip();


            //------------------------------------------------------------------
            //[Navigation Toggle]
            //--
            $('.nav-toggle').click(function () {
                $(this).toggleClass('active');
                $('.header-nav').toggleClass('open');
                event.preventDefault();
            });
            $('.header-nav li a').click(function () {
                $('.nav-toggle').toggleClass('active');
                $('.header-nav').toggleClass('open');

            });

            //------------------------------------------------------------------
            //[Scroll To]
            //--
            $(window).scroll(function () {
                var scroll = $(window).scrollTop();

                if (scroll >= 20) {
                    $('div.navigation').addClass('fixed');
                    $('.header').css({
                        "padding": "28px 0 26px"
                    });
                    $('.header .member-actions').css({
                        "top": "32px",
                    });
                    $('.header .navicon').css({
                        "top": "34px",
                    });
                } else {
                    $('div.navigation').removeClass('fixed');
                    $('.header').css({
                        "padding": "40px 0 30px"
                    });
                    $('.header .member-actions').css({
                        "top": "41px",
                    });
                    $('.header .navicon').css({
                        "top": "48px",
                    });
                }
            });

            //------------------------------------------------------------------
            //[Smooth Scrolling]
            //--
            $('a[href*=#]:not([href=#])').click(function () {
                if (location.pathname.replace(/^\//, '') === this.pathname.replace(/^\//, '') && location.hostname === this.hostname) {

                    var target = $(this.hash);
                    target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                    if (target.length) {
                        $('html,body').animate({
                            scrollTop: target.offset().top
                        }, 2000);
                        return false;
                    }
                }
            });
        }
    }
}();


jQuery(document).ready(function () {
    yimaHomeLogin.init();
});
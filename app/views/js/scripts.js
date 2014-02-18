$(function(){
    try{
        // Tooltips
        $('.hints').tooltip({trigger: 'hover'});
        $('.tips').tooltip({placement: 'left'});
        $('.tip-top').tooltip({placement: 'top'});
        $('.tip-right').tooltip({placement: 'right'});
        $('.tip-bottom').tooltip({placement: 'bottom'});
        // Tour tip
        $('#joyRideTipContent').joyride({'nextButton': false});
    } catch (e){
        errorMessage(e);
    }

    // Popovers
    try{
        $('.pop-top').popover({trigger:'hover', placement: 'top'});
        $('.pop-right').popover({trigger:'hover', placement: 'right'});
        $('.pop-bottom').popover({trigger:'hover', placement: 'bottom'});
        $('.pop-left').popover({trigger:'hover', placement: 'left'});
    } catch (e){
        errorMessage(e);
    }

    // Modal
    try{
        $('.modal').modal('hide');
    } catch (e){
        errorMessage(e);
    }

    // Drop down menu
    $('.breadcrumb li').hover(
        function () {
            //show its submenu
            $('.submenu', this).slideDown(100);

        },
        function () {
            //hide its submenu
            $('.submenu', this).slideUp(100);
        }
    );

    // Mask input
    try{
        $("#date").mask("99/99/9999");
        $("#phone").mask("(999) 999-9999");
        $("#phnext").mask("(999) 999-9999? x99999");
        $("#tin").mask("99-9999999");
        $("#ssn").mask("999-99-9999");
        $('#cid').mask("CID: 9999-aaa-9a*");
        $('#percentage').mask("99%");
    } catch (e){
        errorMessage(e);
    }

    // Data table js call
    try{
        $('.dynamicTable_one').dataTable({
            "bPaginate": true,
            "sPaginationType": "two_button",
            "bLengthChange": false,
            "bFilter": false,
            "bSort": true,
            "bInfo": true,
            "bAutoWidth": false
        });
    } catch (e){
        errorMessage(e);
    }
    try{
        $('.dynamicTable_two').dataTable({
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "bLengthChange": true,
            "bFilter": true,
            "bSort": true,
            "bInfo": true,
            "bAutoWidth": true
        });
    } catch (e){
        errorMessage(e);
    }

    try{
        $('.clickable').click( function(){
            if($(this).find("input").attr("val")==0){
                $(this).find("input").attr("checked",true);
                $(this).find("input").attr("val",1);
            }
            else{
                $(this).find("input").attr("checked",false);
                $(this).find("input").attr("val",0);
            }
        });
    } catch (e){
        errorMessage(e);
    }


    function showMessage(msg){
        message.html(msg);
    }

    /********************************** File upload js end **********************/

    // Responsiveness
    responsiveWindow();

    function errorMessage(e){
        //console.log(e);
    }

    // Isotope Js Call Script Ends

    if ($.browser.msie  && parseInt($.browser.version, 10) === 8) {
        ie8();
    }
});

function responsiveWindow(){
    if(jQuery(this).width() < 600 || jQuery(this).width() <= 1152) {
        jQuery('.sidebar_navigation ul li a > span').css({visibility: 'hidden'});
        jQuery('.sidebar_navigation ul li').css({height: '55px'});
    }else if(jQuery(this).width() > 1152){
        jQuery('.sidebar_navigation ul li a > span').css({visibility: 'visible'});
        jQuery('.sidebar_navigation ul li').css({height: 'auto'});
    }
}

function ie8(){
    $(".header_wrapper .user_nav > li:first-child").css({borderLeft: 'none'});
    $(".header_wrapper .user_nav > li:first-child, .header_wrapper .user_nav > li:last-child").css({height: '38px', padding: 0});
    $(".header_wrapper .user_nav > li:last-child").css({borderRight:"none"});
}
// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

$(function(){

    closeModal = function(){
        $("#modal").removeClass("flex")
    }
    openModal = function(){

        $("#modal").addClass("flex")
    }

    $("#modal > .content").click(function(e){
        e.stopPropagation()
    })
    $("#modal_bt").click(function(e){
        e.stopPropagation()
        openModal()
    })
    $("#modalclose_bt, #modal").click(function(e){
        e.stopPropagation()
        closeModal()
    })

})

function reload(selector, data){
    data = data || {}
    var url = location.href
    console.log("Atualizando " + selector)
    $.post(url,data, function(html){
        var newContent = $(html).find(selector).html()
        $(selector).html(newContent)
    })
}
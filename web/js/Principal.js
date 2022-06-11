jQuery(function () {
    $("#button").on("click", function () {
        $("#button").text($("#container").is(":visible") ? "Mostrar" : "Ocultar");
        $("#container").toggle();
        /*  if ($("#container").is(":visible")) {
             $("#container").hide();
             $("#button").text("Mostrar");
         } else {
             $("#container").show();
             $("#button").text("Ocultar");
         } */
    })
});
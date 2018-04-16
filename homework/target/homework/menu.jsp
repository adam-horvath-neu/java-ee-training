
<style>
#menu a {
	text-decoration: none;
}

#menu {
	width: 200px;
}
</style>

<ul id="menu">
	<li>Tabla</li>
	<li><a href="datatable.jsp">Datatable</a></li>


</ul>
<script>
	$(function() {
		$("#menu").menu({
			items : "> :not(.ui-widget-header)"
		});
	});
</script>

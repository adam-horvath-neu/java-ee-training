
<style>
#menu a {
	text-decoration: none;
}

#menu {
	width: 200px;
}
</style>

<ul id="menu">
	<li><a href="crudAjax.jsp">CrudAjax</a></li>

</ul>
<script>
	$(function() {
		$("#menu").menu({
			items : "> :not(.ui-widget-header)"
		});
	});
</script>

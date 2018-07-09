<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
	
		<div class="col-xs-12">
		
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/property">Property</a></li>
				<li class="active">${property.name}</li>
			
			</ol>

        </div>

	</div>
	
	<div class="row">
	
	    <!-- Display the property image -->
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
			
				<img src="${images}/${property.code}.jsp" class="img img-responsive"/>
			
			</div>
		
		</div>
		
		<!-- Display the property description -->
		<div class="col-xs-12 col-sm-8">
		
			<h3>${property.name}</h3>
			<hr/>
			
			<p>${property.description}</p>
			<hr/>
			
			<h4>Price: <strong>R ${property.bookingPrice} /-</strong></h4>
			<hr/>
			
			<h6>Room(s) Available: ${property.quantity}</h6>
			
			<a href="${contextRoot}/booking/add/${property.id}/property" class="btn btn-success">
			<span class="glyphicon glyphicon-plus"></span>Make Booking</a>
	        <a href="${contextRoot}/show/all/property" class="btn btn-primary">
			Back</a>
		
		</div>
		
	
	</div>

</div>
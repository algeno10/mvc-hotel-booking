$(function() {
	//solving the active menu problem
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Property':
		$('#listproperty').addClass('active');
		break;
	default:
		if(menu == "Home") break;
		$('#listproperty').addClass('active');
	    $('#a_'+menu).addClass(active);
	    break;
	
	}
	
	//code for jquery dataTable
	
	var $table = $('#propertyListTable');
	
	//execute the below code only where we have this table
	if($table.length){
		
		//console.log('Inside the table!');
		
		var jsonUrl ='';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/property';
		}
		else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/property';
		}
			
			
			
		$table.DataTable( {
			
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records', '10 Records','ALL']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				
				{
					data: 'name'
				},
				{
					data: 'address'
				},
				{
					data: 'bookingPrice',
					mRender: function(data, type, row){
						return 'R' + data
					}
				},
				{
					data: 'quantity'
				},
				{
					data: 'id',
					mRender: function(data, type , row){
						var str ='';
						str += '<a href="'+window.contextRoot+ '/show/'+data+'/property">View</a>'
						str += '<a href="'+window.contextRoot+ '/booking/add/'+data+'/property">Make Booking</a>'
					}
					
				}
			]
			
		});
	}

	
});
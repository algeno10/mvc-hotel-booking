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
		$('#listProperty').addClass('active');
		break;
	case 'Manage Properties':
		$('#manageProperty').addClass('active');
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
					data: 'code',
					mRender: function(data, type , row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
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
					data: 'quantity',
					mRender: function(data, type, row){
						
						if(data < 1){
							return '<span style="color:red">Room(s) fully booked</span>'
						}
						return data;
						
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type , row){
						var str ='';
						str += '<a href="'+window.contextRoot+ '/show/'+data+'/property" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						if(row.quantity < 1){
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-plus"></span></a>';
						} else{
							
							str += '<a href="'+window.contextRoot+ '/booking/add/'+data+'/property" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span></a>';
							
						}
					    
						return str;
					}
					
				}
			]
			
		});
	}
	
	//dismissing the alert after 3 seconds
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		}, 3000)
	}

	
});
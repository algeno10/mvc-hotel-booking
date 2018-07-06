<div class="container">

    <div class="row">
      
      <!-- Will display sidebar -->
      <div class="col-md-3">
         <%@include file="./shared/sidebar.jsp"%>
      </div>
    
    
      <!-- To display the actual property -->
      <div class="col-md-9">
           <!-- Added breadcrumb component -->
           <div class="row">
                
                <div class="col-md-12">
                
                     <c:if test="${userClickAllProperty == true}">
                     
                     <script>
                        window.categoryId ='';
                     </script>
                     
                     <ol class="breadcrumb">
                       <li><a href="${contextRoot}/home">Home</a></li>
                       <li class="active">All Property</li>
                     </ol>
                     </c:if>
                     
                     <c:if test="${userClickCategoryProperty == true}">
                     
                     <script>
                        window.categoryId ='${category.id}';
                     </script>
                     
                     <ol class="breadcrumb">
                       <li><a href="${contextRoot}/home">Home</a></li>
                       <li class="active">Category</li>
                       <li class="active">${category.name}</li>
                     </ol>
                     </c:if>
                     
                </div>
           
           </div>
           
           <div class="row">
           
              <div class="col-xs-12">
              
                   <table id="propertyListTable" class="table table-striped table-borderd">
                       
                       <thead>
                       
                         <tr>
                         
                             <th>Name</th>
                             <th>Address</th>
                             <th>Price</th>
                             <th>Room(s) Available</th>
                             <th></th>
                             
                         </tr>
                         
                       </thead>
                       
                       <tfoot>
                       
                         <tr>
                         
                             <th>Name</th>
                             <th>Address</th>
                             <th>Price</th>
                             <th>Room(s) Available</th>
                             <th></th>
                             
                         </tr>
                         
                       </tfoot>
                   </table>
                   
              </div>
              
           </div>
      
      </div>
    
    
    
    </div>


</div>
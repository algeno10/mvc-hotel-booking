<div class="container">

    <div class="row">
      
      <!-- Will display sidebar -->
      <div class="col-md-3">
         <%@include file="./shared/sidebar.jsp"%>
      </div>
    
    
      <!-- To display the property -->
      <div class="col-md-9">
           <!-- Added breadcrumb component -->
           <div class="row">
                
                <div class="col-md-12">
                
                     <c:if test="${userClickAllProperty == true}">
                     <ol class="breadcrumb">
                       <li><a href="${contextRoot}/home">Home</a></li>
                       <li class="active">All Property</li>
                     </ol>
                     </c:if>
                     
                     <c:if test="${userClickCategoryProperty == true}">
                     <ol class="breadcrumb">
                       <li><a href="${contextRoot}/home">Home</a></li>
                       <li class="active">Category</li>
                       <li class="active">${category.name}</li>
                     </ol>
                     </c:if>
                     
                </div>
           
           </div>
      
      
      </div>
    
    
    
    </div>


</div>
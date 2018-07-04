<p class="lead">Property Booking</p>
      <div class="list-group">
      <c:forEach items="${categories}" var="category">
         <a href="${contextRoot}/show/category/${category.id}/property" class="list-group-item">${category.name}</a>
      </c:forEach>
      </div>
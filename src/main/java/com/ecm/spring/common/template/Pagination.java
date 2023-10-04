package com.ecm.spring.common.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecm.spring.common.model.vo.PageInfo;

@Component
public class Pagination {

      @Autowired
      private PageInfo pageInfo;
      
      public PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
         
         int maxPage = (int)Math.ceil((double)listCount/boardLimit);
         maxPage = maxPage == 0 ? 1 : maxPage;
         int startPage = (currentPage -1) / pageLimit * pageLimit +1;
         int endPage = startPage + pageLimit -1;
         endPage = endPage > maxPage ? maxPage : endPage;
         
         pageInfo.setBoardLimit(boardLimit);
         pageInfo.setCurrentPage(currentPage);
         pageInfo.setEndPage(endPage);
         pageInfo.setListCount(listCount);
         pageInfo.setMaxPage(maxPage);
         pageInfo.setPageLimit(pageLimit);
         pageInfo.setStartPage(startPage);
         
         return pageInfo;
      }

}

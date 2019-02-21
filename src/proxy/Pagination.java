package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

@Data
public class Pagination implements Proxy {
	private HttpServletRequest request;
	private int pageNum, pageSize,
				blockNum, blockSize, 
				startPage, endPage, 
				prevBlock, nextBlock, rowCount, proRowCount,
				startRow, endRow, pageCount;
	private boolean existPrev, existNext;

	@Override
	public void carryOut(Object o) {
		System.out.println("------> 페이지네이션 캐리아웃 내부");
		
        HttpServletRequest request = (HttpServletRequest)o;
        
        System.out.println("----request.getParameter(\"page_num\")-----"
                             +request.getParameter("page_num"));
        
       String _pageNum = request.getParameter("page_num");
        pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
        System.out.println("페이지넘버: "+pageNum);//1 2 3 4 5  
       
        String _pageSize = request.getParameter("page_size");
        pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize);
        System.out.println("페이지사이즈: "+pageSize);//5
        
        String _blockSize = request.getParameter("block_size");
        blockSize = (_blockSize == null) ? 5 : Integer.parseInt(_blockSize);
        System.out.println("블록사이즈: "+ blockSize);

        rowCount = CustomerServiceImpl.getInstance().countCustomers(null);
        System.out.println("rowCount: "+ rowCount);
        
        //endRow, startRow
        
        //첫번째 방법 
       /* endRow = rowCount - (pageNum-1) * pageSize;
        startRow = endRow - (pageSize-1);
        if(startRow < 0){startRow = 1;}*/
        
            
        //두번째 방법 
        startRow = (pageNum -1) * pageSize + 1;
        endRow = (rowCount > pageNum * pageSize)? pageNum * pageSize: rowCount;
        
        int pageCount = 0;
        if(rowCount % pageSize != 0) {
            pageCount = rowCount / pageSize + 1;
        } else {
            pageCount = rowCount / pageSize;
        }
   
        System.out.println("스타트로우: " + startRow + "/" + "엔드로우: " + endRow);

        // existPrev, existNext
        existPrev = false;
        existNext = false; 
               
        System.out.println("blockSize"+blockSize);
    
        // blockNum, startPage, endPage
        blockNum = (pageNum -1)/blockSize;
         
        startPage = blockNum * blockSize + 1;
        endPage = startPage + (blockSize-1);
        if(endPage>pageCount) {endPage = pageCount;}
        
        prevBlock = startPage - pageSize;
        nextBlock = startPage + pageSize;
        
        existPrev = prevBlock > 0;
        existNext = nextBlock <= pageCount;
        
	
	}
}

package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页功能
 * @ClassName PaginationDTO
 * @Description TODO
 * @date 2021/5/18 17:45
 * @Version 1.0
 */

@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNextPage;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {


        this.totalPage = totalPage;
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3;i++){
            if (page - i >0){
                pages.add(0,page - i);                //往前头部插入
            }

            if (page + i <= totalPage){
                pages.add(page + i);
            }
        }

        //是否展示前一页
        if (page != 1){
            showPrevious = true;
        }else {
            showPrevious = false;
        }

        //是否展示下一页
        if (page != totalPage){
            showNextPage = true;
        }else {
            showNextPage = false;
        }

        //是否展示第一页
        if (pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }
    }
}

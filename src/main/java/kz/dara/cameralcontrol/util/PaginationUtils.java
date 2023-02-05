//package kz.dara.cameralcontrol.util;
//
//import java.awt.print.Pageable;
//import java.util.Map;
//
//public class PaginationUtils {
//
//    public static Pageable pageable(Map<String, String> params) {
//        Sort dir = Sort.by("id").ascending();
//        int pageSize = 1;
//        int page = 0;
//
//        if (params.containsKey(SORTING)) {
//            dir = params.get(SORTING).charAt(0) == '-' ?
//                    Sort.by(params.get(SORTING).substring(1)).descending() :
//                    Sort.by(params.get(SORTING)).ascending();
//        }
//        if (params.containsKey(PAGE_SIZE)) {
//            pageSize = Integer.parseInt((params.get(PAGE_SIZE)));
//        }
//        if (params.containsKey(PAGE)) {
//            page = Integer.parseInt((params.get(PAGE)));
//        }
//
//        return PageRequest.of(page, pageSize, dir);
//    }
//}

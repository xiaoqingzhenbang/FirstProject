package com.xiaokong.service;

import java.io.InputStream;
import java.util.List;

/**
 * Created by xuebi on 2019/11/22.
 */
public interface ImportService {

    List<List<Object>> getBankListByExcel(InputStream inputStream, String fileName) throws Exception;
}

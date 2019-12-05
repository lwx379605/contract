package com.lmc.shopleasing.service;
import com.lmc.shopleasing.entity.SysArea;
import com.lmc.shopleasing.entity.SysOffice;

import java.util.List;

import com.lmc.shopleasing.core.Service;


/**
 * Created by lmc on 2019/11/02.
 */
public interface SysOfficeService extends Service<SysOffice> {

	List<SysOffice> findChildren(SysOffice parent, boolean b);

	List<SysOffice> findRoots();

}

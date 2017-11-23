/**
* Copyright (C) 2008 Happy Fish / YuQing
*
* FastDFS Java Client may be copied only under the terms of the GNU Lesser
* General Public License (LGPL).
* Please visit the FastDFS Home Page http://www.csource.org/ for more detail.
*/

package com.fuck.mobile.fastdfs;

import java.io.*;
import java.util.*;

import com.fuck.mobile.fastdfs.common.*;

import java.net.*;

/**
* upload file callback interface
* @author Happy Fish / YuQing
* @version Version 1.0
*/
public interface UploadCallback
{
	/**
	* send file content callback function, be called only once when the file uploaded
	* @param out output stream for writing file content
	* @return 0 success, return none zero(errno) if fail
	*/
	public int send(OutputStream out) throws IOException;
}

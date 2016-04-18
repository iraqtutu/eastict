package com.eastict;

import java.util.List;

public interface ServiceSupport<T> {
	List<T> getObjects(int num);
}

package com.packagename.myapp.app.security;

import com.packagename.myapp.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}

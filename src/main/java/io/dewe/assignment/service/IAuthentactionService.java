package io.dewe.assignment.service;

import io.dewe.assignment.model.User;

public interface IAuthentactionService {
    User signInAndReturnJWT(User signInRequest);
}

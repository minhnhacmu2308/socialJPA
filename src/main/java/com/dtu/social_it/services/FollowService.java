package com.dtu.social_it.services;

import com.dtu.social_it.domains.Follow;

public interface FollowService {

    Follow save(Follow follow);

    void unFollow(Follow follow);

}

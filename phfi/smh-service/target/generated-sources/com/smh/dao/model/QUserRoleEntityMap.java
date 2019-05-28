package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserRoleEntityMap is a Querydsl query type for UserRoleEntityMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserRoleEntityMap extends EntityPathBase<UserRoleEntityMap> {

    private static final long serialVersionUID = 1850026378L;

    public static final QUserRoleEntityMap userRoleEntityMap = new QUserRoleEntityMap("userRoleEntityMap");

    public final NumberPath<Long> hceId = createNumber("hceId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> sptsmId = createNumber("sptsmId", Long.class);

    public final NumberPath<Long> tokenId = createNumber("tokenId", Long.class);

    public final NumberPath<Long> userRoleId = createNumber("userRoleId", Long.class);

    public QUserRoleEntityMap(String variable) {
        super(UserRoleEntityMap.class, forVariable(variable));
    }

    public QUserRoleEntityMap(Path<? extends UserRoleEntityMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRoleEntityMap(PathMetadata<?> metadata) {
        super(UserRoleEntityMap.class, metadata);
    }

}


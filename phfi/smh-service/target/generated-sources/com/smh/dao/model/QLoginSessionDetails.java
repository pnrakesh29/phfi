package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QLoginSessionDetails is a Querydsl query type for LoginSessionDetails
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLoginSessionDetails extends EntityPathBase<LoginSessionDetails> {

    private static final long serialVersionUID = 1879077639L;

    public static final QLoginSessionDetails loginSessionDetails = new QLoginSessionDetails("loginSessionDetails");

    public final StringPath browserType = createString("browserType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ipAddress = createString("ipAddress");

    public final DateTimePath<java.sql.Timestamp> lastActivityTime = createDateTime("lastActivityTime", java.sql.Timestamp.class);

    public final StringPath loginStatus = createString("loginStatus");

    public final DateTimePath<java.sql.Timestamp> loginTime = createDateTime("loginTime", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> logoutTime = createDateTime("logoutTime", java.sql.Timestamp.class);

    public final StringPath portalType = createString("portalType");

    public final StringPath sessionId = createString("sessionId");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public QLoginSessionDetails(String variable) {
        super(LoginSessionDetails.class, forVariable(variable));
    }

    public QLoginSessionDetails(Path<? extends LoginSessionDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLoginSessionDetails(PathMetadata<?> metadata) {
        super(LoginSessionDetails.class, metadata);
    }

}


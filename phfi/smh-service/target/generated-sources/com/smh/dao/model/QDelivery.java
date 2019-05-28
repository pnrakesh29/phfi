package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDelivery is a Querydsl query type for Delivery
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDelivery extends EntityPathBase<Delivery> {

    private static final long serialVersionUID = 238722754L;

    public static final QDelivery delivery = new QDelivery("delivery");

    public final StringPath babyWeight = createString("babyWeight");

    public final StringPath deliveryConductedBy = createString("deliveryConductedBy");

    public final StringPath deliveryDate = createString("deliveryDate");

    public final StringPath deliveryPlace = createString("deliveryPlace");

    public final StringPath deliveryType = createString("deliveryType");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath isBabyAlive = createString("isBabyAlive");

    public final StringPath isExcessiveBleeding = createString("isExcessiveBleeding");

    public final StringPath otherPlace = createString("otherPlace");

    public final StringPath pregnancyLast = createString("pregnancyLast");

    public final StringPath visitDate = createString("visitDate");

    public final NumberPath<Integer> wid = createNumber("wid", Integer.class);

    public final StringPath womanName = createString("womanName");

    public QDelivery(String variable) {
        super(Delivery.class, forVariable(variable));
    }

    public QDelivery(Path<? extends Delivery> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDelivery(PathMetadata<?> metadata) {
        super(Delivery.class, metadata);
    }

}


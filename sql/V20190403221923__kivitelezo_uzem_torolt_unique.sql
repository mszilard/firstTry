alter table kivitelezo_uzem
    drop constraint kivitelezo_uzem_uzem_id_kivitelezo_id_key,
    add constraint kivitelezo_uzem_uzem_id_kivitelezo_id_key unique(uzem_id, kivitelezo_id, torolt);
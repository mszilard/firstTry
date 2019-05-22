create table szerelo_skill(
  "szerelo_id" integer not null references szerelo("szerelo_id"),
  "skill_id" integer not null references skill("skill_id")
)
classDiagram
direction BT
class categories {
   varchar(255) name
   text description
   timestamp created_at
   timestamp updated_at
   integer id
}
class comments {
   integer post_id
   integer author_id
   text content
   timestamp created_at
   timestamp updated_at
   integer id
}
class likes {
   integer post_id
   integer user_id
   timestamp created_at
   timestamp updated_at
   integer id
}
class post_categories {
   integer post_id
   integer category_id
}
class post_tags {
   integer post_id
   integer tag_id
}
class posts {
   varchar(255) title
   text content
   text summary
   integer author_id
   timestamp published_at
   timestamp updated_at
   integer id
}
class tags {
   varchar(255) name
   text description
   timestamp created_at
   timestamp updated_at
   integer id
}
class users {
   varchar(255) username
   varchar(255) email
   varchar(255) password
   timestamp created_at
   timestamp updated_at
   integer id
}

comments  -->  posts : post_id:id
comments  -->  users : author_id:id
likes  -->  posts : post_id:id
likes  -->  users : user_id:id
post_categories  -->  categories : category_id:id
post_categories  -->  posts : post_id:id
post_tags  -->  posts : post_id:id
post_tags  -->  tags : tag_id:id
posts  -->  users : author_id:id

-- Insert data into the users table
INSERT INTO users (username, email, password)
VALUES
    ('john_doe', 'john@example.com', 'password123'),
    ('jane_smith', 'jane@example.com', 'pass456'),
    ('mike_jackson', 'mike@example.com', 'secret789');

-- Insert data into the posts table
INSERT INTO posts (title, content, summary, author_id)
VALUES
    ('First Post', 'This is the content of the first post.', 'summary of the first post.', 1),
    ('Second Post', 'This is the content of the second post.', 'summary of the second post.', 2),
    ('Third Post', 'This is the content of the third post.', 'summary of the third post.', 1);

-- Insert data into the categories table
INSERT INTO categories (name, description)
VALUES
    ('Technology', 'Articles related to technology'),
    ('Travel', 'Articles related to travel'),
    ('Food', 'Articles related to food');

-- Insert data into the post_categories table
INSERT INTO post_categories (post_id, category_id)
VALUES
    (1, 1),
    (1, 3),
    (2, 2),
    (3, 3);

-- Insert data into the tags table
INSERT INTO tags (name, description)
VALUES
    ('Programming', 'Articles related to programming'),
    ('Adventure', 'Articles related to adventure'),
    ('Recipes', 'Articles related to recipes');

-- Insert data into the post_tags table
INSERT INTO post_tags (post_id, tag_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the comments table
INSERT INTO comments (post_id, author_id, content)
VALUES
    (1, 2, 'Great post!'),
    (1, 3, 'I enjoyed reading this.'),
    (2, 1, 'Nice work!');

-- Insert data into the likes table
INSERT INTO likes (post_id, user_id)
VALUES
    (1, 3),
    (2, 1),
    (2, 2);
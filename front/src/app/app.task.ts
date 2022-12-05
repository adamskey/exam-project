export class Task {
    id: number;
    taskCategory: string;
    createdTimestamp: string;
    due: string;
    edited: string;
    completed: string;
    title: string;
    description: string;
    username: string;
    priorityName: string;

    constructor(id: number, taskCategory: string, createdTimestamp: string, due: string, edited: string, completed: string,
        title: string, description: string, username: string, priorityName: string) {
        this.id = id;
        this.taskCategory = taskCategory;
        this.createdTimestamp = createdTimestamp;
        this.due = due;
        this.edited = edited;
        this.completed = completed;
        this.title = title;
        this.description = description;
        this.username = username;
        this.priorityName = priorityName;
    }
}
# GraphQL
Simple graphql API for student to register for courses

Stack:
Java, Spring Boot, Web, H2, JPA, GraphQL


Mutations:

mutation {
  newStudent(student: {studentNumber: "123", firstName: "Shri", lastName: "Singh", year: "Sophomore", email: "s@yahoo.in"}){
		year
		email
  }
  
  newCourse(courseName: "Algorithms", courseNumber: "CSE123", credits: 3, semesterOffered: "Winter"){
    courseName
    courseNumber
    credits
    semesterOffered
  }
  
  addCourseToStudent(courseNumber: "CSE123", studentNumber: "123") {
    firstName
  }
 
}

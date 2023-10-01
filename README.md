# Send-Mail Backend Application

**Send-Mail** is a Backend application built using Java and the Spring framework to send emails to employees in the organization. This application automates the sending of important emails to employees, including work schedules, notifications of the total number of working days in a month, and notifications of leave to responsible individuals.

## Types of Emails Sent

The Send-Mail system supports sending three main types of emails:

1. **Work Schedules**
   - Sends monthly work schedules to employees.
   - Work schedules include information about working hours, workdays, and job-related details for the month.

2. **Notification of Total Working Days in a Month**
   - Sends a notification of the total number of working days in the month to employees.
   - This notification helps employees track their work performance for the month.

3. **Notification of Leave to Responsible Individuals**
   - Sends notifications of employee leaves to the responsible manager.
   - This notification helps managers plan for employee absences.

## Usage Guide

To use the Send-Mail system, follow these steps:

1. **Set Up the Environment**

   - Ensure that you have Java and the Spring Framework installed on the server where the application will run.
   - Configure your email account settings in the configuration file (e.g., `application.properties`).

2. **Run the Application**

   - Run the Send-Mail application using the following command:
   
     ```shell
     ./mvnw spring-boot:run
     ```

3. **Schedule Email Sending**

   - Use a cron job or task scheduler to schedule regular email sending to employees.
   - Ensure you configure the types of emails to be sent and determine the appropriate sending times.

4. **Manage Email Templates**

   - Customize email templates within the system to suit your organization's needs.
   - Store email templates in the corresponding directory and update the paths to the email templates in the application.

## Configuration

The Send-Mail system's configuration can be customized through a configuration file. Below are some important configurations:

- **spring.mail.host**: SMTP server email address.
- **spring.mail.port**: SMTP connection port (usually 25 or 587).
- **spring.mail.username**: Email login username.
- **spring.mail.password**: Email password.
- **sendmail.emailTemplatesPath**: Path to the directory containing email templates.

## References

- [Spring Framework Documentation](https://spring.io/projects/spring-framework)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

## Contact
If you have any questions or suggestions, please feel free to contact us at thanhak2k2@gmail.com. We welcome your feedback and contributions to improve the Send-Mail backend application.

Thank you for using and exploring the Send-Mail application!

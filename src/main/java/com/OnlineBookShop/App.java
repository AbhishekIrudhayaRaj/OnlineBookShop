package com.OnlineBookShop;

import java.sql.ResultSet;

import java.util.Scanner;

import com.OnlineBookShop.dao.AdminOperations;
import com.OnlineBookShop.dao.UserOperation;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminOperations aob = new AdminOperations();
		UserOperation up = new UserOperation();
		boolean status = true;
		try {
			do {
				System.out.println("                               _________________________________");
				System.out.println();
				System.out.println("                                      Online Book Shop     ");
				System.out.println("                               _________________________________");

				System.out.println("1-> ADMIN LOGIN");
				System.out.println("2-> CUSTOMER LOGIN");
				int op = sc.nextInt();
				if (op == 1) {
					System.out.println("Please Enter Login_Id");
					String Login_Id = sc.next();
					System.out.println("Please Enter password");
					String Password = sc.next();

					if (aob.login(Login_Id, Password)) {
						System.out.println("-----------------------------------------------------------");
						System.out.println("Login successfull!!");
						System.out.println("-----------------------------------------------------------");
						System.out.println("1.view Books\r\n" + "2.Add Books\r\n" + "3.Remove Books\r\n"
								+ "4.Profile Setting\r\n" + "5.Log Out\r\n");
						int op1 = sc.nextInt();
						if (op1 == 1) {
							aob.viewBooks();
						} else if (op1 == 2) {
							System.out.println("Enter Book Serialno:");
							String bsno = sc.next();
							System.out.println("Enter BookName:");
							String bname = sc.next();
							System.out.println("Enter Book AuthorName:");
							String aname = sc.next();
							System.out.println("Enter pages of book ");
							int pg = sc.nextInt();
							System.out.println("Enter stock of Book:");
							int st = sc.nextInt();
							System.out.println("Enter amount of book:");
							int amt = sc.nextInt();
							if (aob.AddBooks(bsno, bname, aname, pg, st, amt)) {
								System.out.println("Book added successfully");
							} else {
								System.out.println("Something went wrong");
							}

						} else if (op1 == 3) {
							System.out.println("Please Enter the Book Serial Number to Remove the Book");
							String bsno = sc.next();
							if (aob.delete(bsno)) {
								System.out.println("Book Removed Successfully");
							} else {
								System.out.println("Please Enter The Correct Book Serial Number");
							}
						} else if (op1 == 4) {
							System.out.println("Please enter your Employee ID");
							String eid = sc.next();
							System.out.println("Please Provide new Login_Id");
							String lid = sc.next();
							System.out.println("Please provide new Password");
							String np = sc.next();
							if (aob.profileSetting(eid, lid, np)) {
								System.out.println("Updated Successfully");
							} else {
								System.out.println("Problem in Update");
							}
						} else if (op1 == 5) {
							if (aob.logout()) {
								status = false;
								System.out.println("Logged Out");
							}

						}

					} else {
						System.out.println("Login_Id or Password is incorrect");
					}

				} else if (op == 2) {
					System.out.println("1->sign up (New customer)");
					System.out.println("2->sign in (If already a customer)");
					int op2 = sc.nextInt();
					if (op2 == 1) {
						System.out.println("Please Enter the Login_Id");
						String lid = sc.next();
						System.out.println("Please Enter the Password");
						String pwd = sc.next();
						System.out.println("Please Enter the Name");
						String name = sc.next();
						System.out.println("Please Enter the location");
						String loc = sc.next();
						System.out.println("Please Enter the address");
						String add = sc.next();
						System.out.println("Please Enter the E-Mail");
						String em = sc.next();
						System.out.println("Please Enter the Mobile Number");
						long num = sc.nextLong();

						if (up.signUp(lid, pwd, name, add, loc, em, num)) {
							System.out.println("Sign up successfully");
						} else {
							System.out.println("Problem in Sign Up");
						}
					} else if (op2 == 2) {
						System.out.println("Please Enter Login_Id");
						String lid = sc.next();
						System.out.println("Please Enter password");
						String Pwd = sc.next();
						if (up.login(lid, Pwd)) {
							System.out.println("************************************************");
							System.out.println("Login successfull!!");
							System.out.println("************************************************");
							System.out.println("1.View Books\r\n" + "2.Add To Cart\r\n" + "3.View Cart\r\n"
									+ "4.Profile Setting\r\n" + "5.Log Out\r\n");
							int op3 = sc.nextInt();
							if (op3 == 1) {
								up.viewBooks();
							} else if (op3 == 2) {
								up.viewBooks();
								System.out.println("Please Enter the Book Serial Number");
								String bsno = sc.next();
								System.out.println("Please Enter the Quantity");
								int qty = sc.nextInt();

								if (up.addToCart(bsno, qty)) {
									System.out.println("book Added Successfully!!!");
								} else {
									System.out.println("Problem in Adding Item to Cart");
								}
							} else if (op3 == 3) {
								up.viewCart();
								System.out.println("1->Buy now");
								System.out.println("2->Empty Cart");
								int op4 = sc.nextInt();
								if (op4 == 1) {
									System.out.println("Please Enter The BookSerialNumber");
									String bsno = sc.next();
									System.out.println("Please Enter the Bookname");
									String bn = sc.next();
									System.out.println("Please Enter the Quantity");
									int qty = sc.nextInt();
									System.out.println("Please Enter the Delivery Address");
									String address = sc.next();
									if (up.orderNow(bsno, bn, qty, address)) {
										System.out.println("Order Successfully Placed");
									} else {
										System.out.println("Problem in Placing Order");
									}
								} else if (op4 == 2) {
									System.out.println("Enter the Book Serial Number TO Delete Book From Cart:");
									String bsno = sc.next();
									if (up.emptyCart(bsno))

										System.out.println("Successfully Removed BookIn Cart!!");
									else
										System.out.println("Problems in Removing Book from Cart");

								}
							} else if (op3 == 4) {
								System.out.println("Please Enter the Login_Id");
								String lid1 = sc.next();
								System.out.println("Please Enter the Password");
								String pwd = sc.next();
								System.out.println("Please Enter the Name");
								String name = sc.next();
								System.out.println("Please Enter the Location");
								String loc = sc.next();
								System.out.println("Please Enter the address");
								String add = sc.next();

								System.out.println("Please Enter the E-Mail");
								String em = sc.next();
								System.out.println("Please Enter the Mobile Number");
								long num = sc.nextLong();

								if (up.profileSetting(lid1, pwd, name, add, loc, em, num)) {
									System.out.println("Sign up successfully");
								} else {
									System.out.println("Problem in Sign Up");
								}

							} else if (op3 == 5) {
								if (up.logout()) {
									System.out.println("Logged Out Successfully!!");
								} else {
									System.out.println("Problem in Log Out");
								}
							}
						} else {
							System.out.println("Problem in Login");
						}
					}

				}
			} while (status);
		} catch (Exception e) {
			System.out.println("Wrong data!!");
		}

	}
}

use std::io;

fn main(){
    loop{
        let mut string = String::new();
        io::stdin().read_line(&mut string).unwrap();
        let num : u32 = string.trim().parse().unwrap();
        if num == 42
        {
            break;
        }
        println!("{}",num);
    }
}
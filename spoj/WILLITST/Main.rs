use std::io;
//if the number is power of 2, then it will halt, otherwise never.
fn main(){
    //println!("{}",std::u64::MIN);
    let mut num_str : String = String::new();
    io::stdin().read_line(&mut num_str).unwrap();
    //let mut num : u64
    let mut num : u64 = num_str.trim().parse().unwrap();
    if(num < 2){
        println!("NIE");
        println!("TAK");
    }
    else {
        num = num - 1;
        while(num > 0){
            if((num & 1) == 0){
                println!("NIE");
                return;
            }
            num = num >> 1;
        }
        println!("TAK");
    }
}
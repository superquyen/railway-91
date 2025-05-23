package com.data.controller;

import com.data.entity.Account;
import com.data.repository.AccountRepository;
import com.data.req.AccountCreateReq;
import com.data.req.AccountUpdateReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @PostMapping("createAccount")
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountCreateReq accountCreateReq){
        Optional<Account> optionalAccount = accountRepository.findByUsername(accountCreateReq.getUsername());
        if(optionalAccount.isPresent()){
            return ResponseEntity.badRequest().body("Tai khoan da ton tai");
        }
            Account account1 = new Account();
            account1.setCreateDate(accountCreateReq.getCreateDate());
            account1.setEmail(accountCreateReq.getEmail());
            account1.setUsername(accountCreateReq.getUsername());
            account1.setPassword(accountCreateReq.getPassword());
            account1.setRole(accountCreateReq.getRole());
            account1.setBirthDay(accountCreateReq.getBirthDay());
            account1.setAddress(accountCreateReq.getAddress());
            account1.setUpdateDate(accountCreateReq.getUpdateDate());
            accountRepository.save(account1);
        return ResponseEntity.ok("ban da tao moi user thanh cong");
    }
    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccounts(){
        List<Account> accountList = accountRepository.findAll();
        return ResponseEntity.ok(accountList);
    }
    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Integer id,
                                           @RequestBody AccountUpdateReq accountUpdateReq){
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            Account account1 = account.get();
            account1.setUsername(accountUpdateReq.getUsername());
            account1.setEmail(accountUpdateReq.getEmail());
            account1.setPassword(accountUpdateReq.getPassword());
            account1.setRole(accountUpdateReq.getRole());
            accountRepository.save(account1);
            return ResponseEntity.ok(account1);

    }else{
            return ResponseEntity.badRequest().body("khong tim thay account");
        }
}
}

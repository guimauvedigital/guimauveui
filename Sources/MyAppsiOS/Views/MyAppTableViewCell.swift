//
//  MyAppTableViewCell.swift
//  
//
//  Created by Nathan Fallet on 28/01/2022.
//

#if canImport(UIKit)

import UIKit

public class MyAppTableViewCell: UITableViewCell {
    
    let icon = UIImageView()
    let name = UILabel()
    let desc = UILabel()
    
    var url: String?
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        selectionStyle = .none
        accessoryType = .disclosureIndicator
        
        contentView.addSubview(icon)
        contentView.addSubview(name)
        contentView.addSubview(desc)
        
        icon.translatesAutoresizingMaskIntoConstraints = false
        icon.topAnchor.constraint(equalTo: contentView.layoutMarginsGuide.topAnchor).isActive = true
        icon.leadingAnchor.constraint(equalTo: contentView.layoutMarginsGuide.leadingAnchor).isActive = true
        icon.bottomAnchor.constraint(lessThanOrEqualTo: contentView.layoutMarginsGuide.bottomAnchor).isActive = true
        icon.widthAnchor.constraint(equalToConstant: 44).isActive = true
        icon.heightAnchor.constraint(equalToConstant: 44).isActive = true
        icon.layer.masksToBounds = true
        icon.layer.cornerRadius = 8
        
        name.translatesAutoresizingMaskIntoConstraints = false
        name.topAnchor.constraint(equalTo: contentView.layoutMarginsGuide.topAnchor).isActive = true
        name.leadingAnchor.constraint(equalTo: icon.trailingAnchor, constant: 12).isActive = true
        name.trailingAnchor.constraint(equalTo: contentView.layoutMarginsGuide.trailingAnchor).isActive = true
        
        desc.translatesAutoresizingMaskIntoConstraints = false
        desc.topAnchor.constraint(equalTo: name.bottomAnchor, constant: 4).isActive = true
        desc.leadingAnchor.constraint(equalTo: icon.trailingAnchor, constant: 12).isActive = true
        desc.trailingAnchor.constraint(equalTo: contentView.layoutMarginsGuide.trailingAnchor).isActive = true
        desc.bottomAnchor.constraint(lessThanOrEqualTo: contentView.layoutMarginsGuide.bottomAnchor).isActive = true
        desc.font = .systemFont(ofSize: 15)
        desc.textColor = .systemGray
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    public func with(app: MyApp) -> MyAppTableViewCell {
        self.name.text = app.name
        self.desc.text = NSLocalizedString(app.description, bundle: .module, comment: app.description)
        self.icon.image = UIImage(named: app.icon, in: .module, compatibleWith: nil)
        self.url = app.url
        
        return self
    }
    
    public func openURL() {
        if let url = url, let urlObject = URL(string: url) {
            if #available(iOS 10.0, *) {
                UIApplication.shared.open(urlObject)
            } else {
                UIApplication.shared.openURL(urlObject)
            }
        }
    }

}

#endif
